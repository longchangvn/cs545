import './post.css'
const Post = ({post})=>{

    return <>
    <div className="post">
        <h3>{post.title}</h3>
        <h6>{post.author}</h6>
        <button className="follow">Follow</button>
    </div>
    </>
}

export default Post