import React, { useEffect, useState } from "react"
import Post from "./post"
import './post.css'
import { getAllPost, getPostById } from "../../service/post.service"


const Posts = ({onItemClick, data}) => {
    // const [data, setData] = useState([
    //     // {
    //     //     id: 111,
    //     //     title: "Happiness",
    //     //     author: "John",
    //     //     content:"This is the content in the post 111"

    //     // },
    //     // {
    //     //     id: 112,
    //     //     title: "MIU",
    //     //     author: "Dean",
    //     //     content:"This is the content in the post 112"
    //     // }
    //     // , {
    //     //     id: 113,
    //     //     title: "Enjoy Life",
    //     //     author: "Jasmine",
    //     //     content:"This is the content in the post 113"
    //     // }
    // ])
   
    const itemClickHandler=(post)=>{
        onItemClick(post)
    }
    
    return <div className="post-detail">
        {
            data.map(d=>{
                return <Post key={d.id} data={d} itemClick={()=>itemClickHandler(d)}></Post>
            })
        }
    </div>
}

export default Posts