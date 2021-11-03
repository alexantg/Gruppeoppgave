<template id="admin-create-antiqueshop">
  <div className="app">
    <center><h1>Admin</h1>
      <form class="create" @submit="checkForm" :action=`/api/admin/create` method="post">
        <h2>Registrer ny antikkbutikk</h2>

        <p>
          <label htmlFor="butikknavn">Butikknavn</label>
          <input name="butikknavn" id="butikknavn">
        </p>

        <p>
          <label htmlFor="email">E-mail</label>
          <input name="email" id="email">
        </p>

        <p>
          <label htmlFor="fakturaadresse">Fakturaadresse</label>
          <input name="fakturaadresse" id="fakturaadresse">
        </p>

        <p>
          <input type="submit" value="Register">
        </p>

      </form>
    </center>
  </div>
</template>

<script>
Vue.component("admin-create-antiqueshop", {
  template: "#admin-create-antiqueshop",
  data: () =>({
    butikknavn : null,
    email: null,
    fakturaadresse: null
  })

});
</script>

<style>
h1 {
  color: black;
}

h2 {
  color: black;
  text-decoration: underline;
}

.form {
  font-family: 'Open Sans Condensed', arial, sans;
  width: 500px;
  padding: 30px;
  background: white;
  border: 1px solid black;
  margin: 50px auto;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
  -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
  -webkit-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
}

.form h2 {
  background: #4D4D4D;
  text-transform: uppercase;
  font-family: 'Open Sans Condensed', sans-serif;
  color: white;
  font-size: 18px;
  font-weight: 100;
  padding: 20px;
  margin: -30px -30px 30px -30px;
}

.form input[type="text"],
.form input[type="date"],
.form input[type="datetime"],
.form input[type="email"],
.form input[type="number"],
.form input[type="search"],
.form input[type="time"],
.form input[type="url"],
.form input[type="password"],
.form textarea,
.form select {
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  outline: none;
  display: block;
  width: 100%;
  padding: 7px;
  border: none;
  color: black;
  border-bottom: 1px solid #ddd;
  background: transparent;
  margin-bottom: 10px;
  font: 16px Arial, Helvetica, sans-serif;
  height: 45px;
}

.form textarea {
  resize: none;
  overflow: hidden;
}

.form input[type="button"],
.form input[type="submit"] {
  background: none;
  display: inline-block;
  cursor: pointer;
  font-family: 'Open Sans Condensed', sans-serif;
  font-size: 14px;
  text-decoration: none;
  text-transform: uppercase;
  padding: 10px;
  margin: 10px;
  border: 1px solid black;
  color: black;
  border-radius: 15px;
}

.form input[type="button"]:hover,
.form input[type="submit"]:hover {
  border: 2px solid black;
}

</style>