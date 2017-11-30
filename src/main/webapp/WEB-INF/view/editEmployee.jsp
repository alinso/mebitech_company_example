<jsp:include page="partials/reactHeader.jsp" />
<script type="text/babel">
    document.title = "Edit/New Employee";
    getJSONP("/editEmployeeRest/${employee_id}",function(data) {

        var saveIt = function () {
            var eData  ={};
            eData.name  = document.getElementById("employeeName").value;
            eData.id = data['id'];
            eData.surname  = document.getElementById("employeeSurname").value;
            eData.salary  = document.getElementById("employeeSalary").value;
            eData.departmentId  = document.getElementById("departmentId").value;
            postJSONP("/save-employee", JSON.stringify(eData),function (result) {
                console.log(result);
            });
        }


        function createSelectItems() {
            console.log(data);
            let items = [];
            for (let i = 0; i < data.departments.length; i++) {
                items.push(<option  value={data.departments[i].id}>{data.departments[i].name}</option>);
            }
            return items;
        }

        function onDropdownSelected(e) {
            console.log("THE VAL", e.target.value);
        }

        const formInstance = (
            <form>
                <FieldGroup
                        id="employeeName"
                        type="text"
                        label="Employee Name"
                        placeholder="Enter text"
                        defaultValue = {data.name}
                />
                <FieldGroup
                        id="employeeSurname"
                        type="text"
                        label="Employee Surname"
                        placeholder="Enter text"
                        defaultValue = {data.surname}

                />

                <FieldGroup
                        id="employeeSalary"
                        type="text"
                        label="Employee Salary"
                        placeholder="Enter Number"
                        defaultValue = {data.salary}

                />


                <ReactBootstrap.FormGroup controlId="formControlsSelect">
                    <ReactBootstrap.ControlLabel>Select</ReactBootstrap.ControlLabel>
                    <ReactBootstrap.FormControl componentClass="select" placeholder="select" id="departmentId" onChange={onDropdownSelected} >
                        {createSelectItems()}
                    </ReactBootstrap.FormControl>
                </ReactBootstrap.FormGroup>

        <ReactBootstrap.Button type="button" onClick={saveIt}>
            Save Employee
            </ReactBootstrap.Button>
            </form>
    );


        ReactDOM.render(formInstance, container);



    });

</script>