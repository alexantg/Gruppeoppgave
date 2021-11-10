<template id="add-item">
  <div>
    <h1>Registrer ny antikvitet</h1>
    <form class="form-style" :action=`/api/user/:shop-id/createItem` method="post">
      <p>
        <label for="itemName">Navn</label>
        <input type="text" name="itemName" id="itemName">
      </p>

      <p>
        <label for="description">Beskrivelse</label>
        <input type="text" name="description" id="description">
      </p>

      <p>
        <label for="pictureUrl">Bildeadresse</label>
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
  </div>
</template>

<script>
Vue.component("user-shop-add-item",{
  template:"#add-item"
})
</script>

<style scoped>
h1{
  color: black;
}
</style>