import { Route, Routes } from "react-router"
import LandingPage from "./components/landingpage"
import Posts from "./components/post/posts"
import NewPost from "./components/post/newpost"
import Login from "./components/login/login"
import AuthRoute from "./components/login/auth.route"


const PostRoutes = () => {
    
    return <Routes>
        <Route path="/authenticate" element={<Login></Login>}></Route>
        <Route path="/" element={<AuthRoute></AuthRoute>}>
            <Route path="posts" element={<Posts></Posts>}></Route>
            <Route path="new-post" element={<NewPost></NewPost>}></Route>
        </Route>
    </Routes>
}

export default PostRoutes