<template id ="login">

  <center><h1>Login page</h1></center>
  <p><a class="button" href="">User</a></p>
  <p><a class="button" href="">Admin</a></p>

</template>

<script>
  Vue.component("login", {template:"#login"});
</script>

<style>
  h1 {
    color: black;
  }
  .button {
    padding: 15px;
    margin: 10px;
    border: 2px solid black;
    color: black;
    border-radius: 15px;
  }
</style>