export default {
    props: ['title'],
    template: `
    <div>
      <input v-model="nameField" placeholder="Name" type="text" ref="nameInput">
      <input v-model="ingredientsField" placeholder="Ingredients" @keyup.enter="save()">
      <input v-model="instructionsField" placeholder="Instructions" @keyup.enter="save()">
      <button type="button" @click="save()">Save</button>
    </div>
    <div>
      <h3> {{ title }} </h3>
        <table>
          <thead>
          <tr>
            <th>Name</th>
            <th>Ingredients</th>
            <th>Instructions</th>
          </tr>
          </thead>
          <tbody>
          <tr v-if="items.length === 0">
            <td colspan="2">No recipes yet</td>
          </tr>
          <tr v-for="total recipes">
            <td>{{recipe.name}}</td>
            <td>{{recipe.ingredients}}</td>
            <td>{{recipe.instructions}}</td>
          </tr>
          <tr>
            <td>{{ nameField }}</td>
            <td>{{ ingredientsField }}</td>
            <td>{{ instructionsField }}</td>
          </tr>
          </tbody>
        </table>
    </div>
  `,
    data() {
        return {
            items: [],
            nameField: '',
            ingredientsField: '',
            instructionsField: '',
        };
    },
    methods: {
        loadRecipes() {
            axios
                .get('/getrecipes')
                .then(response => (this.items = response.data))
        },
        save() {
            axios
                .post('/postrecipes', {
                    name: this.nameField,
                    ingredients: this.ingredientsField,
                    instructions: this.instructionsField
                })
                .then((response) => {
                    this.nameField = '';
                    this.ingredientsField = '';
                    this.instructionsField = '';
                    this.$refs.nameInput.focus();
                    this.loadRecipes();
                }, (error) => {
                    console.log('Could not save recipe!');
                });
        },
    },
    mounted: function() {
        this.loadRecipes();
    }
}