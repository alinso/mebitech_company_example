<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="partials/reactHeader.jsp" />

<script type="text/babel">
    setPageTitle("Enrolled Departments");

    getJSONP("/showAttendantRest/${meeting_id}",function(obj) {
        console.log(obj);

        var addAttendant = function () {
            var meetingData  ={};
            meetingData.meetingId  = obj.meeting.id;
            meetingData.departmentId  = document.getElementById("departmentId").value;
            postJSONP("/add-department-to-meeting", JSON.stringify(meetingData),function (result) {
                console.log(result);
            });
        };


        function createSelectItems() {
            let items = [];
            for (let i = 0; i < obj.allDepartments.length; i++) {
                items.push(<option key={obj.allDepartments[i].id}  value={obj.allDepartments[i].id}>{obj.allDepartments[i].name}</option>);
            }
            return items;
        }

        const formInstance = (
                <form>
                    <ReactBootstrap.FormGroup controlId="formControlsSelect">
                        <ReactBootstrap.ControlLabel>Select Department</ReactBootstrap.ControlLabel>
                        <ReactBootstrap.FormControl componentClass="select" placeholder="select" id="departmentId" >
                            {createSelectItems()}
                        </ReactBootstrap.FormControl>
                    </ReactBootstrap.FormGroup>

                    <ReactBootstrap.Button type="button" onClick={addAttendant}>
                        Add To Meeting
                    </ReactBootstrap.Button>
                </form>
        );

        ReactDOM.render(formInstance, container);
        var titleSecond  =document.createElement("div");
        container.appendChild(titleSecond);
        ReactDOM.render(<hr/>,titleSecond);



        class TableRow extends React.Component {
            render() {
                const {
                    data
                } = this.props;

                const row = data.map((data) =>

                        <tr>
                            <td key={data.name}>{data.name}</td>
                            <td key={data.id}><button className="btn btn-danger" onClick={() => deleteRecord('/delete-employee'+data.id)}> REMOVE DEPARTMENT</button></td>
                        </tr>
                );
                return (
                        <tbody>{row}</tbody>
                );
            }
        }

        class Table extends React.Component {
            constructor(props) {
                super(props);
            }
            render() {
                return (
                        <table className="table table-striped">
                            <thead><tr><td>Name</td><td>Action</td></tr></thead>
                            <TableRow data={this.props.data} />
                        </table>
                );
            }
        }

        var listingDiv  =document.createElement("div");
        container.appendChild(listingDiv);
        ReactDOM.render(<Table data={obj.meetimgDepartments} />, listingDiv);

    });

</script>

