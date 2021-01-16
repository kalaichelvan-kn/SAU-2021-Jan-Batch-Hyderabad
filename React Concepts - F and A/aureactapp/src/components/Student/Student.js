import React from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faTimes } from "@fortawesome/free-solid-svg-icons";

library.add(faTimes);

class Student extends React.Component {

   constructor(props) {
      super(props);

      this.state = {
         usershead: ['Id','Name','Email','Phone','Website','Action'],
         users: [],
         isFetching : true
      };
      this.fetchUsersWithFetchAPI();
    }

   async fetchUsersWithFetchAPI(){
        this.setState({...this.state, isFetching: true});
        await fetch('https://jsonplaceholder.typicode.com/users')
            .then(response => response.json())
            .then(result => {
                this.setState({...this.state, users: result, isFetching: false});
                console.log(this.state.users);
            })
            .catch(e => {
                console.log(e);
                this.setState({...this.state, users: [], isFetching: false});
            });
    };

   renderTableHeader(){
      return this.state.usershead.map((key, index) => {
          return <th key={index}>{key}</th>
      })
  }

  removeRow(tempid){
    console.log('deleting: ',tempid);
    var array = this.state.users;
    var filtered = array.filter(function(obj){ 
       return obj.id !== tempid;
    });
    this.setState({ ...this.state, users:filtered });
  }

  renderTableData() {
      return this.state.users.map((user, index) => {
         const { id, name, email, phone, website } = user;
         return (
            <tr key={id}>
               <td>{id}</td>
               <td>{name}</td>
               <td>{email}</td>
               <td>{phone}</td>
               <td>{website}</td>
               <td>
                <FontAwesomeIcon icon='times' onClick={()=>{this.removeRow(id)}} />
               </td>
            </tr>
         )
      })
   }
  
   render() {
      return (
         <div>
            <h1 id='title'>React ApiCall User Table</h1> { (this.state.isFetching)? 'loading...':null }
            <table id='users' border="1">
               <thead>
               <tr>{this.renderTableHeader()}</tr>
               </thead>
               <tbody>
                  {this.renderTableData()}
               </tbody>
            </table>
         </div>
      )
   }
}
export default Student;