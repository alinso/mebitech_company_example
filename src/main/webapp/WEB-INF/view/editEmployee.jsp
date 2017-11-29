<jsp:include page="partials/reactHeader.jsp" />
<script>
    getJSONP("/editEmployeeRest/${employee_id}",function(data) {
        document.title = data['title'];



        var buttonGroupInstance = React.createElement(
            "form",
            null,
            React.createElement(FieldGroup, {
                id: "employeeName",
                type: "text",
                label: "Employee Name",
                placeholder: "Enter text",
                value:data['name']
            }),

            React.createElement(FieldGroup, {
                id: "employeeSurname",
                type: "text",
                label: "Employee Name",
                placeholder: "Enter text"
            }),

            React.createElement(FieldGroup, {
                id: "employeeSalary",
                type: "text",
                label: "Employee Salary",
                placeholder: "Enter text"
            }),

            React.createElement(
                ReactBootstrap.FormGroup,
                { controlId: "employeeDepartment" },
                React.createElement(
                    ReactBootstrap.ControlLabel,
                    null,
                    "Employee Dep"
                ),
                React.createElement(
                    ReactBootstrap.FormControl,
                    { componentClass: "select", placeholder: "select" },
                    React.createElement(
                        "option",
                        { value: "select" },
                        "select"
                    ),
                    React.createElement(
                        "option",
                        { value: "other" },
                        "other"
                    )
                )
            )

        );

            ReactDOM.render(buttonGroupInstance, container);


    });

</script>