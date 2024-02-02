import { useContext, useEffect, useState } from "react"
import { Navigate, Outlet, useLocation, useNavigate } from "react-router"
import { AuthService } from "../../auth.service"
import Login from "./login"

const AuthRoute = () => {

    const location = useLocation()
    const [isAuthenticated, setIsAuthenticate] = useState(AuthService.isAuthenticated())
    
    

    // useEffect(() => {
    //     console.log(isAuthenticated)
    //     if (!isAuthenticated)
    //         navigate("/authenticate")
    // }, [isAuthenticated])
    return <>
    {
        isAuthenticated ? <Outlet></Outlet> : <Navigate to="/authenticate"></Navigate>
    }</>

}

export default AuthRoute