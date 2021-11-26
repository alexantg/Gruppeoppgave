<template id="mainpage-user">
  <div>
    <div>
      <center> <h2>Registered shops</h2></center>
      <center>
        <p><a class="button" href="registershop/">Registrer ny butikk</a></p>
      </center>
      <center> <ul class="shops-overview-list">
        <li v-for="shop in shops">
          <a :href="`/user/${shop.name.trim()}`" class="link-to-shop-details">
            <div class="single-shop-container" >
              <h1>{{shop.name}}</h1>
            </div>
          </a>
        </li>
      </ul>
      </center>
    </div>
  </div>
</template>

<script>
Vue.component("mainpage-user",
    {template: "#mainpage-user",
      data: () => ({
        shops: [],
      }),
      created(){
        fetch("/api/shops")
            .then(res => res.json())
            .then(res =>{
              this.shops = res;
            })
            .catch(() => alert("Error while fetching saved shops"));
      }

    });

</script>
<style>
li{
  list-style-type: none;
}

.shop-overview-list{
  margin-top: 50px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.shop-overview-list li{
  padding: 10px;

}

.link-to-shop-details-details{
  width: 400px;
  height:100px;
  text-decoration: none;
  color: black;
}

div.single-shop-container{
  overflow: hidden;
  width: 300px;
  background-color: white;
  opacity: 0.96;
  text-align: center;
  border: 1px solid black ;
  border-radius: 15px;
  margin: 20px;
}

div.single-shop-container:hover{
  opacity: 1.0;
  overflow: hidden;
  -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
  -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
  box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
}

img.cover-image-frontpage {
  width: 125px;
  height: 125px;
  padding-bottom: 20px;
  max-height: 280px;
}

.button {
  padding: 15px;
  margin: 10px;
  border: 2px solid black;
  color: black;
  border-radius: 15px;
}

.button a{
  color: black;
  text-decoration: none;
  font-weight: bold;
}

.button:hover{
  border: 2px solid black;
}
h2{
  font-size: 40px;
  text-decoration: none;
  color: black;

}
</style>