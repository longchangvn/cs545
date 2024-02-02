import { useContext, useState } from "react"
import { AuthService } from "../../auth.service"

const Login = () => {
    const [userName, setUserName] = useState("")
    const loginHandler = () => {
        AuthService.loginSuccess(userName)
    }
    return <>
    this is login
        <form>
            <div>
                <label>User name</label>
                <input type="text" onChange={(e) => setUserName(e.target.value)} name="username" />
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" />
            </div>
            <button onClick={loginHandler}> Login</button>
        </form>
    </>
}

export default Login