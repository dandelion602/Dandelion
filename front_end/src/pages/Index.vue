<template>
  <q-page class="">
    <div class="row">
      <div v-for="item in itemList" :key="item.number" class="col-4 cardArea">
        <div v-if="item.status === 0">
          <q-card class="myCard" @click="onDetail(item.number)">
            <q-img
              :src="
                require('../assets/images/' +
                  item.itemImages[0].fileName +
                  item.itemImages[0].format)
              "
              :ratio="1"
            />

            <q-card-section>
              <div class="text-h6">{{ item.title }}</div>
              <div class="text-h6 text-right">
                {{ numberWithCommas(item.price) }}원
              </div>
            </q-card-section>

            <q-card-section class="q-pt-none">
              {{ item.centents }}
            </q-card-section>
          </q-card>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script>
import axios from "axios";
export default {
  name: "PageIndex",
  data() {
    return {
      itemList: []
    };
  },

  mounted() {
    this.item_list();
  },

  methods: {
    onDetail(itemId) {
      this.$router.push(`/main/detail/${itemId}`);
    },
    numberWithCommas(num) {
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    item_list() {
      axios
        .get("api/")
        .then(res => {
          this.itemList = res.data.filter(data => data.status === 0);
          console.log(res.data);
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>
<style lang="scss" scoped>
.cardArea {
  padding: 30px;
  .myCard {
    cursor: pointer;
    transition: all 0.2s ease-in-out;
    &:hover {
      transform: scale(1.03);
    }
  }
}
</style>
