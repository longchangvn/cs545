import React, { useEffect, useMemo, useState } from "react"
import Posts from "../../components/post/posts"
import PostDetailView from "../../components/post/post-detail-view"
import { getAllPost } from "../../service/post.service"
import AddPost from "../../components/post/add.post"
import Comment from "../../components/comment/comment"
import { PostContext } from "../../context/post.context"

const Dashboard = () => {
    const reloadPost = () => {
        getAllPost().then(res => { setPosts(res.data) })
    }
    const [postDetail, setPostDetail] = useState(null)
    const [currentText, setCurrentText] = useState("")
    const [posts, setPosts] = useState([])
    const [context, setContext] = useState({ post: {}, reloadData: reloadPost })

    const postClickedHandler = (post) => {
        console.log(post)
        setPostDetail(post)

    }
    const updateText = () => {
        postDetail.title = currentText;
        setPostDetail({ ...postDetail })
    }


    useEffect(() => {
        if (postDetail) {
            setCurrentText(postDetail.title)
            setContext({ ...context, post: postDetail })
        }

    }, [postDetail])
    useEffect(() => {

        getAllPost().then(res => {
            setPosts(res.data);
        })
    }, [])

    const commentMemo = useMemo(() => <Comment post={postDetail}></Comment>, [postDetail])
    const postDetailView = useMemo(()=><>{postDetail ? <PostDetailView></PostDetailView> : "No Post Selected"}</>,[postDetail, context])
    return <div>
        Dashboard
        <PostContext.Provider value={context}>
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
                        {postDetailView}
                    </div>
                    <div className="row">
                        {commentMemo}
                    </div>
                </div>
                <div className="editor">
                    <AddPost postAdded={reloadPost}></AddPost>
                </div>
            </div>
        </PostContext.Provider>

    </div>
}
export default Dashboard