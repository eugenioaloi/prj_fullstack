<template>
  <div>

    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="8"
      max-width="448"
      rounded="lg"
    >

    <div class="d-flex justify-center">
        <v-card-title class="text-h5 text-md-h5 text-lg-h4">
          Login to portal
        </v-card-title>
    </div>

      <!--E-mail component  -->
      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Email
      </div>
      <v-text-field
        density="compact"
        placeholder="Email address"
        prepend-inner-icon="mdi-email-outline"
        variant="outlined"
        v-model="email"
      />
      
      <!--Password component  -->
      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Password
      </div>
      <v-text-field
        :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
        :type="visible ? 'text' : 'password'"
        density="compact"
        placeholder="Enter your password"
        prepend-inner-icon="mdi-lock-outline"
        variant="outlined"
        @click:append-inner="visible = !visible"
        v-model="password"
      />
    
      <!--Button component  -->
      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        :disabled ="formValid"
        @click="formSubmit"
      >
      Log In </v-btn>
  
      <v-card-text class="text-center">
        <a
          class="text-blue text-decoration-none"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
          Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
        </a>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
  data: () => ({
    visible: false,
    email: "",
    password: "",
  }),
  methods:{
    formSubmit(){
      console.log("email ", this.email);
      console.log("psw ", this.password);
    }
  },
  computed:{
    formValid(){
      return this.email =="" || this.password ==""?true:false
    },
  }
  
}
</script>