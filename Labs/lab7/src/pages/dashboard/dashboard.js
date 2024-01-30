import React, { useEffect, useState } from "react"
import Posts from "../../components/post/posts"
import PostDetailView from "../../components/post/post-detail-view"
import { getAllPost } from "../../service/post.service"
import AddPost from "../../components/post/add.post"
import Comment from "../../components/comment/comment"

const Dashboard = () => {
    const [postDetail, setPostDetail] = useState(null)
    const [currentText, setCurrentText] = useState("")
    const [posts, setPosts] = useState([])
    const postClickedHandler = (post) => {
        setPostDetail(post)
        console.log(post)
    }
    const updateText = () => {
        postDetail.title = currentText;
        setPostDetail({ ...postDetail })
    }

    const reloadPost = () => {
        getAllPost().then(res => { setPosts(res.data) })
    }
    useEffect(() => {
        if (postDetail)
            setCurrentText(postDetail.title)
    }, [postDetail])
    useEffect(() => {

        getAllPost().then(res => {
            setPosts(res.data);
        })
    }, [])
    return <div>
        Dashboard

        <div className="row">
            <Posts data={posts} onItemClick={postClickedHandler}></Posts>
        </div>
        <div className="row">
            <input type="text" value={currentText} onChange={(e) => setCurrentText(e.target.value)} />
            <button onClick={updateText}>Change</button>
        </div>
        <div className="inline">
            <div className="detail">
                <div className="row">
                    {postDetail ? <PostDetailView post={postDetail} reloadData={reloadPost}></PostDetailView> : "No Post Selected"}
                </div>
                <div className="row">
                    <Comment post={postDetail}></Comment>
                </div>
            </div>
            <div className="editor">
                <AddPost postAdded={reloadPost}></AddPost>
            </div>
        </div>


    </div>
}
export default Dashboard