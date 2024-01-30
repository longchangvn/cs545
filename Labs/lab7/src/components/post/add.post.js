import { useState } from "react"
import { addPost } from "../../service/post.service"

const AddPost = ({ postAdded }) => {
    const [post, setPost] = useState({})
    const addPostHandler = () => {
        addPost(post).then(res => {
            alert("New Post added")
            postAdded();
        })
    }
    const onInputChange = (name, e) => {
        post[name] = e.target.value;
        setPost({ ...post });
    }
    return <div className="add-post">
        <h1>Add new Post</h1>
        <div className="row">
            <label>Title</label>
            <input value={post.title} onChange={(e) => onInputChange("title", e)} />
        </div>
        <div className="row">
            <label>Author</label>
            <input value={post.author} onChange={(e) => onInputChange("author", e)} />
        </div>
        <div className="row">
            <label>Content</label>
            <input value={post.content} onChange={(e) => onInputChange("content", e)} />
        </div>
        <div className="row">
            <button onClick={addPostHandler}>Add Post</button>
        </div>
    </div>
}

export default AddPost