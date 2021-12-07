<template id ="add-item">
  <div class="app">
    <center> <h1>Registrer ny antikvitet</h1>
      <form class="form-style" :action=`/api/user/createitem` method="post">
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
Vue.component("add-item",{
  template:"add-item"
})
</script>

<style>
h1{
  color: black;
}
</style>