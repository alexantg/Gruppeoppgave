<template id="item-detail">
  <div v-if="item">
    <center> <h1> Auksjon av {{item.name}}</h1>
      <center> <ul class="item-list">
        <li>
          <div class="single-item-container" >
            <h1>{{item.name}}</h1>
            <p>{{item.description}}</p>
            <p>Pris: {{item.price}}</p>
            <img v-if="item.pictureUrl" class="cover-image" v-bind:src="item.pictureUrl">
            <p><a class="button">Gi bud</a></p>
          </div>
        </li>
      </ul>
      </center>
    </center>
  </div>
</template>

<script>
Vue.component("item-detail", {
  template: "#item-detail",
  data: () => ({
    item: null,
    shopName: "",
  }),
  created() {
    const shopId = this.$javalin.pathParams["shop-id"];
    this.shopName = shopId;
    const itemId = this.$javalin.pathParams["item-id"];
    fetch(`/api/enduser/${shopId}/items/${itemId}`)
        .then(res => res.json())
        .then(res => this.item = res)
        .catch(() => alert("Error while fetching item"));
  }
});
</script>

<style>
h1{
  color:black;
}
</style>