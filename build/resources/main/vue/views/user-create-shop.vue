<template id="user-create-shop">
  <div class="app">
    <center> <h1>Registrer ny antikkbutikk</h1>
      <form class="form-style" :action=`/api/user/createshop` method="post">
        <p>
        <label for="shopName">Navn</label>
        <input type="text" name="shopName" id="shopName">
        </p>

        <p>
          <label for="email">E-post</label>
          <input type="text" name="email" id="email">
        </p>

        <p>
          <label for="address">Adresse</label>
          <input type="text" name="address" id="address">
        </p>

        <p>
          <input type="submit" value="Registrer">
        </p>

      </form>
    </center>
  </div>
</template>

<script>
Vue.component("user-create-shop", {
  template: "#user-create-shop",
  data: () => ({
    shopName: null,
    email: null,
    address: null
  })
});
</script>

<style>
h1 {
  color: black;
}
h2{
  color: black;
  text-decoration: underline;
}

.form-style{
  font-family: 'Open Sans Condensed', arial, sans;
  width: 500px;
  padding: 30px;
  background: white;
  border: 1px solid black;
  margin: 50px auto;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
  -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
  -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);
}
.form-style h2{
  background: #4D4D4D;
  text-transform: uppercase;
  font-family: 'Open Sans Condensed', sans-serif;
  color: white;
  font-size: 18px;
  font-weight: 100;
  padding: 20px;
  margin: -30px -30px 30px -30px;
}
.form-style input[type="text"],
.form-style input[type="date"],
.form-style input[type="datetime"],
.form-style input[type="email"],
.form-style input[type="number"],
.form-style input[type="search"],
.form-style input[type="time"],
.form-style input[type="url"],
.form-style input[type="password"],
.form-style textarea,
.form-style select
{
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
.form-style textarea{
  resize:none;
  overflow: hidden;
}
.form-style input[type="button"],
.form-style input[type="submit"]{
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
.form-style input[type="button"]:hover,
.form-style input[type="submit"]:hover {
  border: 2px solid black;
}

</style>