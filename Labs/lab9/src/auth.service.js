export let AuthService = {
  loginSuccess: function(username) {
    //setContext({ ...context, isAuthenticated: true, userName: username })
    sessionStorage.setItem("user", JSON.stringify({ userName: username }))
    alert("Login successfully")
  }
  ,
  getLoggedInUser: function(){
    let user = sessionStorage.getItem("user")

    return JSON.parse(user)

  },
  isAuthenticated: function() {
    console.log("user:",(this.getLoggedInUser()?.userName || "") !=="")
    return (this.getLoggedInUser()?.userName || "") !==""
  }
  , logout: function() {
    sessionStorage.removeItem("user")
  }
}

