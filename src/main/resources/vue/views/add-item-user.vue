<template id="add-item-user">
  <center> <h1>Registrer ny Antikvitet</h1>
    <form class="form-style" :action=`/api/user/${shopId}/createItem` method="post">
      <p>
        <label for="itemName">Navn på antikvitet</label>
        <input type="text" name="itemName" id="itemName">
      </p>

      <p>
        <label for="description">Beskrivelse</label>
        <input type="text" name="description" id="description">
      </p>

      <p>
        <label for="pictureUrl">Bilde (Link)</label>
        <input type="text" name="pictureUrl" id="pictureUrl">
      </p>

      <p>
        <label for="price">Pris</label>
        <input type="text" name="price" id="price">
      </p>

      <p>
        <input type="submit" value="Registrer">
      </p>

    </form>
  </center>
</template>

<script>
Vue.component("add-item-user", {
  template: "#add-item-user",
  data: () => ({
    shopId: null,
    itemName: null,
    description: null,
    pictureUrl: null,
    price: null
  }),
  created (){
    this.shopId = this.$javalin.pathParams["shop-id"];
}
});
</script>

<style>
h1{
  color:black;
}

</style>