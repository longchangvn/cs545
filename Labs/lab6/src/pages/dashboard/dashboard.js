import React, { useEffect, useState } from "react"
import Posts from "../../components/post/posts"
import PostDetailView from "../../components/post/post-detail-view"

const Dashboard = () => {
    const [postDetail, setPostDetail] = useState(null)
    const [currentText, setCurrentText] = useState("")
    const postClickedHandler = (post) => {
        setPostDetail(post)
        console.log(post)
    }
    const updateText = () => {
        postDetail.Title = currentText;
        setPostDetail({ ...postDetail })
    }
    useEffect(() => {
        if (postDetail)
            setCurrentText(postDetail.Title)
    }, [postDetail])
    return <div>
        Dashboard

        <div className="row">
            <Posts onItemClick={postClickedHandler}></Posts>
        </div>
        <div className="row">
            <input type="text" value={currentText} onChange={(e) => setCurrentText(e.target.value)} />
            <button onClick={updateText}>Change</button>
        </div>
        <div className="row">
            {postDetail ? <PostDetailView post={postDetail}></PostDetailView> : "No Post Selected"}
        </div>

    </div>
}
export default Dashboard