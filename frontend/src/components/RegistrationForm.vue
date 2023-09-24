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
          {{ header }}
        </v-card-title>
    </div>

      <!--Name component  -->
      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Name
      </div>
      <v-text-field
        density="compact"
        placeholder="Enter your name"
        prepend-inner-icon="mdi-account-plus-outline"
        variant="outlined"
        v-model="user_name"
        :rules = "[rules.user_nameReq]"
      />

      <!--Surname component  -->
      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
          Surname
      </div>
      <v-text-field
        density="compact"
        placeholder="Enter your surname"
        prepend-inner-icon="mdi-account-plus-outline"
        variant="outlined"
        v-model="user_surname"
        :rules = "[rules.user_surnameReq]"
      />

      <!--E-mail component  -->
      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Email
      </div>
      <v-text-field
        density="compact"
        placeholder="Enter email address"
        prepend-inner-icon="mdi-email-outline"
        variant="outlined"
        v-model="email"
        :rules = "[emailRules]"
      />
      
      <!--Password component  -->
      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Password
      </div>
      <v-text-field
        :append-inner-icon="visiblePassword ? 'mdi-eye-off' : 'mdi-eye'"
        :type="visiblePassword ? '' : 'password'"
        density="compact"
        placeholder="Enter your password"
        prepend-inner-icon="mdi-lock-outline"
        variant="outlined"
        @click:append-inner="visiblePassword = !visiblePassword"
        v-model="password"
        :rules = "[passwordRules]"
      />

      <!--Password confirmation component  -->
      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Password confirmation
      </div>
      <v-text-field
        :append-inner-icon="visiblePasswordConfirmation ? 'mdi-eye-off' : 'mdi-eye'"
        :type="visiblePasswordConfirmation ? '' : 'password'"
        density="compact"
        placeholder="Confirm your password"
        prepend-inner-icon="mdi-lock-check-outline"
        variant="outlined"
        @click:append-inner="visiblePasswordConfirmation = !visiblePasswordConfirmation"
        v-model="passwordConfirm"
        :rules = "[passwordConfirmationRules]"
      />
    
      <!--Button component  -->
      <v-btn
        block
        class="mb-8"
        color="green"
        size="large"
        :disabled ="formValid"
        @click="handleRegistration"
      >
      Register </v-btn>
      
    </v-card>
  </div>
</template>
  
<script>

export default{

  data() {
    return {
      header: 'Registration',
      user_name: '',
      user_surname:'',
      email: '',
      password: '',
      passwordConfirm: '',
      visiblePassword: false,
      visiblePasswordConfirmation: false,
      rules:{
          user_nameReq: req => !!req || "Name is required",
          user_surnameReq: req => !!req || "Surname is required",
      }
    };
  },
  methods: {
    handleRegistration(){
        console.log("name", this.user_name);
        console.log("surname", this.user_surname);
        console.log("email", this.email);
        console.log("password", this.password);
        console.log("password confirm", this.passwordConfirm);
    },
    emailRules(){
      if(!this.email){
        return "Email is required";
      }else{
        let validate_email = this.emailValidation(this.email)?true:false;
        if(!validate_email){
          return "Email has to be valid ex: abc@xyz.com";
        }
      }
      return true;
    },
    emailValidation(){
      let str = String(this.email);
      let index_at = str.indexOf('@');
      if(index_at>0){
        let sub_Str = str.substring(index_at,str.length);
        let index_dot = sub_Str.indexOf('.');
        if(index_dot>0){
          let dom_str = sub_Str.substring(index_dot,str.length)
          if(dom_str.length>2){
            return true;
          }
        }
      }
      return false;
    }, 
    passwordRules(){

      let psw = this.password

      let validateLength = psw.length >7 && psw.length <11? true:false;
      let hasUpperCase = this.pswHasUpperCase(psw)?true:false;
      let hasNumber = this.pswHasNumber(psw)?true:false;

      if (!validateLength){
        return "Password needs to between 8 and 10 characters, contains at least a number and capital letter";
      }else{
        if(!hasUpperCase || !hasNumber){
            return "Password needs to between 8 and 10 characters, contains at least a number and capital letter";
        }
      }
      return true;
    },
    pswHasNumber(str){
      let string = String(str);
      for(let i=0;i<string.length;i++){
          let ch = string.charAt(i);
          if(!isNaN(ch)){
              return true;
          }
      }
      return false;
    },
    pswHasUpperCase(str){
      let string = String(str);
      for(let i=0;i<string.length;i++){
          let ch = string.charAt(i);
          if(ch == ch.toUpperCase() ){
              return true;
          }
      }
      return false;
    },
    passwordConfirmationRules(){
      if(!this.passwordConfirm){
        return "Password is required"  
      }else {
        if(this.password != this.passwordConfirm){
          return "Password are not the same"
        }  
      }
      return true
      
    },  
  },
  computed:{
    formValid(){
      let fieldsEmpty = this.user_name!="" && this.user_surname!="" &&  this.email !="" && this.password !="" && this.passwordConfirm !="" ;
      
      //TO DO:implement disable for all the validation, not just empty fields
      //HINT: function not always return boolean or result expected

      return  !fieldsEmpty ? true : false;
    },
  }
}

</script>
  