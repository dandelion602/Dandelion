<template>
  <q-page class="">
    <div class="row">
      <div class="col-9 q-pa-md">
        <h3>상품 상세 페이지</h3>
        <div class="row">
          <div class="col-6">
            <div class="q-pa-md">
              <q-carousel
                swipeable
                animated
                v-model="slide"
                thumbnails
                infinite
              >
                <q-carousel-slide v-for="image in curItem.images" :key="image.number" :name="image.orderNumber" :img-src="require('../assets/images/' + image.fileName +image.format)">
                </q-carousel-slide>
              </q-carousel>
            </div>
          </div>
          <div class="col-6 q-px-md">
            <div class="text-h4 q-mb-none q-mt-md">{{curItem.title}}</div>
            <div class="text-subtitle1 q-mt-sm">{{curItem.contents}}</div>
            <div class="text-h4 q-mt-xl text-right">{{ numberWithCommas(curItem.price) }}원</div>
            <div class="text-right">
              <q-btn color="primary q-mt-xl " :to="`/buy/${curItem.number}`">구매하기</q-btn>
            </div>
          </div>
        </div>


      </div>
      <div class="col-3">
        <q-list bordered separator class="cardArea ">
          <q-item clickable v-ripple v-for="item in itemList" :key="item.number" @click="onDetail(item.number)">
            <q-item-section avatar>
              <q-avatar rounded>
                <q-img
                  :src="require('../assets/images/' + item.images[0].fileName + item.images[0].format)"
                  :ratio="1"
                />
              </q-avatar>
            </q-item-section>
            <q-item-section>
              {{item.title}}
              <q-item-label caption>Caption</q-item-label>
            </q-item-section>

            <q-item-section side>{{ numberWithCommas(item.price) }}원</q-item-section>
          </q-item>
        </q-list>
      </div>
    </div>
  </q-page>
</template>

<script>
import axios from "axios";

export default {
  name: 'Detail',
  data () {
    return {
      itemList: [],
      slide: 0
    }
  },
  mounted() {
    this.items()
  },
  computed: {
    itemId () {
      return this.$route.params.itemId
    },
    curItem () {
      return this.itemList.filter(i => i.number == this.itemId)[0]
    }
  },
  methods : {
    onDetail (itemId) {
      this.$router.push(`/detail/${itemId}`)
    },
    numberWithCommas(num) {
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    items () {
      axios
        .get('http://localhost:9090/')
        .then(res => {
          this.itemList = res.data
          console.log(this.itemList)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }

}
</script>
<style lang="scss" scoped>
</style>
