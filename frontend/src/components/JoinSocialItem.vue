<script setup>
import { ref } from "vue";

import axios from "axios";

const nickname = ref("");
const password = ref("");

const go = function () {
  const data = {
    nickname: nickname.value,
    password: password.value,
  };

  axios
    .post("/api/join/social", data)
    .then((res) => {
      console.log(res);
      //   window.location.href = "/";
    })
    .catch((err) => {
      console.log(err);
    });
};
</script>

<template>
  <div>
    <p>안녕하세요</p>
    <div>
      <div>닉네임</div>
      <input type="text" name="nickname" v-model="nickname" />
    </div>
    <div>
      <div>비밀번호</div>
      <input type="password" name="password" v-model="password" />
    </div>
    <div>
      <button @click="go()">계정생성</button>
    </div>
  </div>
</template>

<style scoped></style>
