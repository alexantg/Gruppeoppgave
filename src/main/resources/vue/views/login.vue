<template id="login">
  <div id="app">
    <center><h1>Logg in som </h1>
    <p><a class="button" href="admin/">Oppstartbedriften (Administrator)</a></p>
    <br>
    <p><a class="button" href="user/">Butikk eier (Bruker)</a></p>
    <br>
    <p><a class="button" href="enduser/">Kunde av antikk butikk (Sluttbruker)</a></p>
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