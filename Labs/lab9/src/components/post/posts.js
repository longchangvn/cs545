import { useState } from "react"
import Post from "./post"

const Posts = () => {
    const [data, setData] = useState([
        {
            "id": 1,
            "title": "Spring MVC - restful getting started",
            "content": "This is content of restful api",
            "author": "Martin fower",
            "comments": []
        },
        {
            "id": 2,
            "title": "JPA",
            "content": "This is content of restful api",
            "author": "Prof 1",
            "comments": []
        },
        {
            "id": 3,
            "title": "Spring Security",
            "content": "This is content of restful api",
            "author": "Prof 2",
            "comments": []
        },
        {
            "id": 4,
            "title": "Spring Web",
            "content": "This is content of restful api",
            "author": "prof 3",
            "comments": []
        }
    ])
    return <div className="posts">{
        data.map(d => {
            return <Post post={d} key={d.id}></Post>
        })
    }</div>
}

export default Posts