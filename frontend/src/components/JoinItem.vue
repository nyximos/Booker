<script setup>
import { ref } from "vue";

import axios from "axios";

const username = ref("");
const password = ref("");

const join = function () {
  axios.post("/api/join", {
    username: username.value,
    password: password.value,
  });
};
</script>

<template>
  <div>
    <p>안녕하세요</p>
    <div>
      <input type="text" name="username" v-model="username" />
    </div>
    <div>
      <input type="text" name="password" v-model="password" />
    </div>
    <div>
      <button @click="join()">완료</button>
    </div>
  </div>
</template>

<style scoped></style>
