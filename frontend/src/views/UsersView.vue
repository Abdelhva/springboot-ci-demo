<script setup>
import { onMounted, ref } from 'vue'
import api from '../services/api'
const users = ref([])

onMounted(async () => {
  const res = await api.get('/users')
  users.value = res.data
  console.log(res)
})
</script>
<template>
  <div>
    <h1>Users</h1>
    <ul>
      <li v-for="u in users" :key="u.id">
        ({{u.username}})
      </li>
      <li>
      </li>
    </ul>
  </div>
</template>