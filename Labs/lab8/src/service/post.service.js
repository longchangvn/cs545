import axios from "axios";

const API = axios.create({
    baseURL:"http://localhost:8080/"
})

export function getAllPost(){
    return API.get("posts")
}

export function getPostById(id){
    return API.get("posts/" + id)
}

export function deletePostById(id){
    return API.delete("posts/" + id)
}

export function addPost(data){
    return API.post("posts",data)
}
