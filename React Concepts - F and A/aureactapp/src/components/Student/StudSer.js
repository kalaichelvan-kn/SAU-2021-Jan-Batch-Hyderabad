async function callApi(){
    fetch("https://api.github.com/users/hadley/orgs")
      .then((res) => res.json())
      .then((res) => {
        this.setState({ data: res });
    });
}

export default callApi;