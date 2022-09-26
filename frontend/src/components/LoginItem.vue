<script setup>
import { ref } from "vue";

import axios from "axios";

const title = ref("");
const content = ref("");

const write = function () {
  axios.post("/api/test", {
    title: title.value,
    content: content.value,
  });
};
</script>

<template>
  <div>
    <p>안녕하세요</p>
    <div>
      <input type="text" name="title" v-model="title" />
    </div>
    <div>
      <input type="text" name="content" v-model="content" />
    </div>
    <div>
      <button @click="write()">완료</button>
    </div>
  </div>
</template>

<style scoped></style>
