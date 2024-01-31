import React, { useContext } from "react"
import './post.css'
import { deletePostById, getAllPost } from "../../service/post.service";
import { PostContext } from "../../context/post.context";
const PostDetailView = () => {
    const context = useContext(PostContext)
    console.log(context)
    const edithandler = (e) => {
        e.preventDefault();
        alert("Editing:" + context.post.id)
    }
    const deletehandler = (e) => {
        e.preventDefault();
        deletePostById(context.post.id).then(res=>{
            if(res.data){
                alert(`Post Id: ${context.post.id} is deleted`)
                context.reloadData();
            }
        })
    }
    return <div className="post-detail-view">
        <div className="row">{context.post.title}</div>
        <div className="row">{context.post.author}</div>
        <div className="row post-content">{context.post.content}</div>
        <div className="row">
            <a href="#" className="action" onClick={(e) => { edithandler(e) }}>edit</a>
            <a href="#" className="action" onClick={(e) => { deletehandler(e) }}>delete</a>
        </div>
    </div>
}
export default PostDetailView