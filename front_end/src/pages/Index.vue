<template>
  <q-page class="">
    <div class="row">
      <div v-for="item in itemList" :key="item.number" class="col-4 cardArea">
        <q-card class="myCard" @click="onDetail(item.number)">
<<<<<<< HEAD

=======
>>>>>>> 5d80c621fa0b03595b881e4cc6186efa2a6f3c8a

          <q-img
            :src="require('../assets/images/' + item.images[0].fileName + item.images[0].format )"
            :ratio="1"
            />

<<<<<<< HEAD
          <q-card-section>
            <div class="text-h6">{{item.title}}</div>
            <div class="text-h6 text-right">{{ numberWithCommas(item.price) }}원</div>
          </q-card-section>

          <q-card-section class="q-pt-none">
            {{ item.centents }}
=======
            <q-card-section>
              <div class="text-h6">{{item.title}}</div>
              <div class="text-h6 text-right">{{ numberWithCommas(item.price) }}원</div>
            </q-card-section>


          <q-card-section class="q-pt-none">
            {{ item.contents }}
>>>>>>> 5d80c621fa0b03595b881e4cc6186efa2a6f3c8a
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>

</template>

<script>
import axios from "axios";
<<<<<<< HEAD

=======
>>>>>>> 5d80c621fa0b03595b881e4cc6186efa2a6f3c8a
export default {
  name: 'PageIndex',
  data() {
    return {
      itemList: []
    }
  },
<<<<<<< HEAD

  mounted() {
    this.item_list()
  },

=======
  mounted() {
    this.mainItem()
  },
>>>>>>> 5d80c621fa0b03595b881e4cc6186efa2a6f3c8a
  methods : {
    onDetail (itemId) {
      this.$router.push(`/detail/${itemId}`)
    },
    numberWithCommas(num) {
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
<<<<<<< HEAD
    item_list() {
=======
    mainItem() {
>>>>>>> 5d80c621fa0b03595b881e4cc6186efa2a6f3c8a
      axios
        .get('http://localhost:9090/')
        .then(res => {
          this.itemList = res.data;
<<<<<<< HEAD
=======
          console.log(this.itemList);
>>>>>>> 5d80c621fa0b03595b881e4cc6186efa2a6f3c8a
        })
        .catch(err => {
          console.log(err);
        })
    }
  }
}
</script>
<style lang="scss" scoped>
  .cardArea {
    padding: 30px;
    .myCard {
      cursor: pointer;
      transition: all .2s ease-in-out;
      &:hover {
        transform: scale(1.03);
      }
    }
  }
</style>
