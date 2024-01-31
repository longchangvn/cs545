import { useRef, useState } from "react"
import { addPost } from "../../service/post.service"

const AddPost = ({ postAdded }) => {
    const [post, setPost] = useState({})
    const formRef = useRef(null);
    const addPostHandler = (e) => {
        e.preventDefault()
        let post = {
            "title":formRef.current["title"].value,
            "author":formRef.current["author"].value,
            "content":formRef.current["content"].value
        }
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
        <form ref={formRef}>
            <div className="row">
                <label>Title</label>
                <input name="title" value={post.title} />
            </div>
            <div className="row">
                <label>Author</label>
                <input name="author" value={post.author}  />
            </div>
            <div className="row">
                <label>Content</label>
                <input name="content" value={post.content} />
            </div>
            <div className="row">
                <button onClick={(e)=>addPostHandler(e)}>Add Post</button>
            </div>
        </form>
    </div>
}

export default AddPost