<template id="login">
  <div id="app">
    <center><h1>Login Page</h1>
    <p><a class="button" href="admin/">Admin</a></p>
    <br>
    <p><a class="button" href="user/">User</a></p>
    <br>
    <p><a class="button" href="enduser/">End User</a></p>
    </center>
  </div>

</template>


<script>
Vue.component("login", {template: "#login"});
</script>


<style>
 h1 {
  color: black;
}
 .button {
   text-decoration: none;
   padding: 10px;
   margin: 10px;
   border: 1px solid black;
   color: black;
   border-radius: 15px;
 }
</style>