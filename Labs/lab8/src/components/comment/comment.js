import React from "react"
const Comment = ({ post }) => {
    console.log("comment render....")
    return <div className="comment">
        {post && post.comments?.length > 0 ? post.comments.map(c => {
            return <div key={c.id} className="comment-content">
                {c.comment}
            </div>
        }) : "No Comment"}</div>
}
export default Comment;