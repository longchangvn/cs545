import React, { useState } from "react"
import Post from "./post"
import './post.css'

const Posts = ({onItemClick}) => {
    const [data, setData] = useState([
        {
            Id: 111,
            Title: "Happiness",
            Author: "John",
            Content:"This is the content in the post 111"

        },
        {
            Id: 112,
            Title: "MIU",
            Author: "Dean",
            Content:"This is the content in the post 112"
        }
        , {
            Id: 113,
            Title: "Enjoy Life",
            Author: "Jasmine",
            Content:"This is the content in the post 113"
        }
    ])
    const itemClickHandler=(post)=>{
        onItemClick(post)
    }
    return <div className="post-detail">
        {
            data.map(d=>{
                return <Post key={d.Id} data={d} itemClick={()=>itemClickHandler(d)}></Post>
            })
        }
    </div>
}

export default Posts