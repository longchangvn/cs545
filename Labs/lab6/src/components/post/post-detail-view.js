import React from "react"
import './post.css'
const PostDetailView = ({ post }) => {
    const edithandler = (e) => {
        e.preventDefault();
        alert("Editing:" + post.Id)
    }
    const deletehandler = (e) => {
        e.preventDefault();
        alert("Deleting :" + post.Id)
    }
    return <div className="post-detail-view">
        <div className="row">{post.Title}</div>
        <div className="row">{post.Author}</div>
        <div className="row post-content">{post.Content}</div>
        <div className="row">
            <a href="#" className="action" onClick={(e) => { edithandler(e) }}>edit</a>
            <a href="#" className="action" onClick={(e) => { deletehandler(e) }}>delete</a>
        </div>
    </div>
}
export default PostDetailView