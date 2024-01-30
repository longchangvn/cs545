import React from "react"
import './post.css'
import { deletePostById, getAllPost } from "../../service/post.service";
const PostDetailView = ({ post, reloadData }) => {
    const edithandler = (e) => {
        e.preventDefault();
        alert("Editing:" + post.id)
    }
    const deletehandler = (e) => {
        e.preventDefault();
        deletePostById(post.id).then(res=>{
            if(res.data){
                alert(`Post Id: ${post.id} is deleted`)
                reloadData();
            }
        })
    }
    return <div className="post-detail-view">
        <div className="row">{post.title}</div>
        <div className="row">{post.author}</div>
        <div className="row post-content">{post.content}</div>
        <div className="row">
            <a href="#" className="action" onClick={(e) => { edithandler(e) }}>edit</a>
            <a href="#" className="action" onClick={(e) => { deletehandler(e) }}>delete</a>
        </div>
    </div>
}
export default PostDetailView