import './post.css'
const Post = ({ data, itemClick }) => {
   const clickHandler=()=>{
    itemClick(data);
   }
    return <div className="post-container" onClick={()=>{clickHandler()}}>
        <div className="row">
            <label>Id:</label>
            <span>{data.id}</span>
        </div>
        <div className="row">
            <label>Title:</label>
            <span>{data.title}</span>
        </div>
        <div className="row">
            <label>Author:</label>
            <span>{data.author}</span>
        </div>
    </div>
}

export default Post