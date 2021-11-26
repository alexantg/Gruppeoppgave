<template id="add-item-user">
  <center> <h1>Registrer ny Antikvitet</h1>
    <form class="form-style" :action=`/api/user/createitem` method="post">
      <p>
        <label for="itemName">Navn på antikvitet</label>
        <input type="text" name="itemName" id="itemName">
      </p>

      <p>
        <label for="description">Beskrivelse</label>
        <input type="text" name="description" id="description">
      </p>

      <p>
        <label for="description">Pris</label>
        <input type="text" name="address" id="address">
      </p>

      <p>
        <input type="submit" value="Registrer">
      </p>

    </form>
  </center>
</template>

<script>
Vue.component("add-item-user", {template: "#add-item-user"});

</script>

<style>
h1{
  color:black;
}

</style>