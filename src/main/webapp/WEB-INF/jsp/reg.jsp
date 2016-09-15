
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Regestration</title>
    </head>
    <body>


          <form action="create"  method="post">
          <div >
              ${error}
          </div>

              <input placeholder="Name" name="name"   required>

              <input type="email" name="email" placeholder="Email"   required>


               <input type="password" name="password" placeholder="Password"  required>

          <button type="submit"  >Sign up</button>

          <p><small>Already have an account?</small></p>
          <a href="login" >Sign in</a>
        </form>
      </div>

    </div>


</div>
    </body>
</html>
