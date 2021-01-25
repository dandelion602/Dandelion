<template>
  <div class="q-pa-md">
    <q-table
      :grid="$q.screen.xs"
      title="구매내역"
      :data="data"
      :columns="columns"
      row-key="name"
      :filter="filter"
    >
      <!--ㄴ 정렬헤더 숨기고 싶으면 사용 hide-header -->
      <template v-slot:top-right>
        <q-input borderless dense debounce="300" v-model="filter" placeholder="Search">
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>
      </template>
    </q-table>
  </div>
</template>

<script>
export default {
    computed:{
        numberWithCommas(price) {
            return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        }
    },
    data () {
    return {
      filter: '',
      columns: [
        {
          name: 'desc',
          required: true,
          label: '상품 이름',
          align: 'left',
          field: row => row.name,
          format: val => `${val}`,
          sortable: true
        },
        { name: 'price', align: 'center', label: 'Price', field: 'price', sortable: true },
        { name: 'dealmethod', label: '거래방법', field: 'dealmethod', sortable: true },
        { name: 'location', label: '거래장소', field: 'location' }
      ],
      data: [
        {
          name: '니니즈 키체인',
          price: 10000,
          dealmethod: '픽업',
          location: '신림역'
        },
        {
          name: '브라운 텀블러',
          price: 43000,
          dealmethod: '버드',
          location: '낙성대역'
        },
        {
          name: '미니가습기',
          price: 23000,
          dealmethod: '버드',
          location: '건대입구역'
        },
        {
          name: '아이패드 4세대 256기가 셀룰러',
          price: 1200000,
          dealmethod: '버드',
          location: '낙성대역'
        },
        {
          name: '로지텍 무선마우스 g506',
          price: 78000,
          dealmethod: '픽업',
          location: '신림역'
        },
        {
          name: '아카시아 화이트 정사각 찬기',
          price: 5000,
          dealmethod: '버드',
          location: '신림역'
        },
        {
          name: '몽블랑 카드지갑 새제품',
          price: 100000,
          dealmethod: '버드',
          location: '낙성대역'
        },
        {
          name: '미생물 음식물처리기',
          price: 490000,
          dealmethod: '버드',
          location: '건대입구역'
        },
        {
          name: '닌텐도 스위치',
          price: 320000,
          dealmethod: '픽업',
          location: '낙성대역'
        },
        {
          name: '강화유리 필름 아이폰6,7,8플러스',
          price: 1000,
          dealmethod: '버드',
          location: '낙성대역'
        },

      ]
    }
    }
}
</script>