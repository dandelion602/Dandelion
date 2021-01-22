<template>

  <div class="q-pa-md">
    <q-form @submit="onSubmit" class="col-12 text-center self-center" >
      <div class="col-12 text-center self-center">
        <h2 class="title"> 내 정보 수정 </h2>
      </div>
      <!-- 사진업로드 -->

      <!-- 이름 작성 -->
      <div class="col-12 text-center self-center">
        <q-avatar class="self-center" size="200px">
          <img src="https://mblogthumb-phinf.pstatic.net/MjAxOTEwMjlfNDUg/MDAxNTcyMzI5NDcwNjIz.aW2F-SaHTjtOHNUlRixK7I_scEWzQDe7k-JHLkxj9_wg.fKoqWcVf8Y-vVCKGpIqUCy--2rC8Na4pHoGawaOwmVcg.PNG.moonkuki/SE-c0ad31f7-b153-4905-9f10-9d81b853e1e6.png?type=w800">
        </q-avatar>
      </div>

      <div class="col-12 text-center self-center">
        <q-item-section>
          <q-btn class="col-12 text-center self-center" label="Add Photo"  rounded color="info" style="max-width: 120px"></q-btn>
        </q-item-section>
      </div>

      <q-item class="col-lg-12 col-md-6 col-sm-12 col-xs-12">
        <q-item-section>
          <q-input v-model="user_details.id" label="id" stack-label :dense="dense" readonly />
        </q-item-section>
      </q-item>

      <q-item class="col-lg-12 col-md-6 col-sm-12 col-xs-12">
        <q-item-section>
          <q-input type="password" v-model="user_details.password" label="password" stack-label :dense="dense" readonly/>
        </q-item-section>
      </q-item>

      <q-item class="col-lg-12 col-md-8 col-sm-12 col-xs-12">
        <q-item-section>
          <q-input v-model="user_details.name" label="name" stack-label :dense="dense" />
        </q-item-section>
      </q-item>

      <q-item class="col-lg-12 col-md-9 col-sm-12 col-xs-12">
        <q-item-section>
          <q-input v-model="user_details.phone" label="phone" stack-label :dense="dense" />
        </q-item-section>
      </q-item>

      <q-item class="col-lg-12 col-md-10 col-sm-12 col-xs-12">
        <q-item-section>
          <q-input v-model="user_details.address" label="address" stack-label :dense="dense" />
        </q-item-section>
      </q-item>



      <!--      <input type="file" ref="uploadImage" @change="onImageUpload()" class="form-control" required>-->
      <!--  -->
      <div>
        <q-btn label="수정하기" type="submit" color="primary"/>
      </div>
    </q-form>

    <q-card v-if="submitResult.length > 0" flat bordered class="q-mt-md bg-grey-2">
      <q-card-section>Submitted form contains the following formData (key = value):</q-card-section>
      <q-separator />
      <q-card-section class="row q-gutter-sm items-center">
        <div
          v-for="(item, index) in submitResult"
          :key="index"
          class="q-px-sm q-py-xs bg-grey-8 text-white rounded-borders text-center text-no-wrap"
        >{{ item.name }} = {{ item.value }}
        </div>
      </q-card-section>
    </q-card>

  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      name: '',
      submitResult: [],
      text: '',
      textarea: '',
      ph: '',
      price:'',
      formData: null,

      dense : false,

      user_details: {
        id: "nadaYoung",
        password: "nada",
        name: "나다용",
        phone: "010-1234-1234",
        address: "관악구"
      },
      password_dict: {}
    }
  },
  methods: {
    onSubmit() {
      const formData = {
        title: this.name,
        price: this.price,
        contents: this.textarea
      }

      let file = this.$refs.uploadImage.files;
      this.formData = new FormData();
      file.forEach((file) => this.formData.append("files", file));

      axios
        .post('http://localhost:9090/addBoard', formData)
        .then(res => {
          console.log(res.data)
          axios
            .post('http://localhost:9090/fileupload/', this.formData)
            .then(res => {
              console.log(res);
            })
        })
        .catch(err => {
          console.log(err);
        })
    }
  }
}
</script>

<style lang="scss" scoped>
.q-pa-md{
  padding: 5% 30%;
  max-width: 100%;
  height: 100vhs;
  display: flex;
  position: absolute;


  .q-input{
    max-width: 600px;
  }
}
.title{
  text-align: center;
}
.q-gutter-md{

}

</style>
