<jsp:include page="partials/reactHeader.jsp" />
<script type="text/babel">
    getJSONP("/editDepartmentRest/${department_id}",function(data) {
        document.title = data['title'];

        var saveIt = function () {
            var dData  ={};
            dData.name  = document.getElementById("departmentName").value;
            dData.id = data['id'];
            dData.description  = document.getElementById("departmentDescription").value;

            console.log(dData);
            postJSONP("/save-department", JSON.stringify(dData),function (result) {
                console.log(result);
            });
        }




        const formInstance = (
                <form>
                    <FieldGroup
                            id="departmentName"
                            type="text"
                            label="Department Name"
                            placeholder="Enter Name"
                            defaultValue = {data.name}
                    />
                    <FieldGroup
                            id="departmentDescription"
                            type="text"
                            label="Employee Surname"
                            placeholder="Enter Description"
                            defaultValue = {data.description}

                    />


                    <ReactBootstrap.Button type="button" onClick={saveIt}>
                        Save Department
                    </ReactBootstrap.Button>
                </form>
        );


        ReactDOM.render(formInstance, container);



    });

</script>