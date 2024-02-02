import { Link, useNavigate } from 'react-router-dom'
import './header.css'
import { useContext, useEffect, useState } from 'react'

import { AuthService } from '../../auth.service'
const Header = () => {
    const navigate = useNavigate();
    const [userName, setUserName] = useState({})
    const [isAuthenticated, setIsAuthenticate] = useState()
    const logout = (e) => {
        e.preventDefault();
        AuthService.logout(e);
        reloadStatus()
        navigate("/authenticate")

    }
    const reloadStatus = () => {
        setUserName(AuthService.getLoggedInUser()?.userName)
        setIsAuthenticate(AuthService.isAuthenticated());
    }
    useEffect(() => {
        reloadStatus()

    }, [])

    return <div className="header">
        <ul>
            <li><Link to="/posts">Posts</Link></li>
            <li><Link to="/new-post">New Posts</Link></li>
        </ul>

        {isAuthenticated ? <div className='right-div'>
            <div>profile</div>
            <div>Welcome, {userName}</div>
            <div><a href='#' onClick={(e) => logout(e)}>Logout</a> </div>
        </div> :
            <div className="right-div"><Link to="authenticate">sign in</Link> </div>}
    </div>
}
export default Header