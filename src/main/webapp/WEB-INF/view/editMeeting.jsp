<jsp:include page="partials/reactHeader.jsp" />
<script type="text/babel">

    setPageTitle("Edit/New Meeting");

    getJSONP("/editMeetingRest/${meeting_id}",function(data) {

        var saveIt = function () {
            var dData  ={};
            dData.name  = document.getElementById("meetingName").value;
            dData.id = data['id'];
            dData.description  = document.getElementById("meetingDescription").value;

            console.log(dData);
            postJSONP("/save-meeting", JSON.stringify(dData),function (result) {
                console.log(result);
            });
        }




        const formInstance = (
                <form>
                    <FieldGroup
                            id="meetingName"
                            type="text"
                            label="Meeting Name"
                            placeholder="Enter Name"
                            defaultValue = {data.name}
                    />
                    <FieldGroup
                            id="meetingDescription"
                            type="text"
                            label=" Meeting Description"
                            placeholder="Enter Description"
                            defaultValue = {data.description}

                    />


                    <ReactBootstrap.Button type="button" onClick={saveIt}>
                        Save Meeting
                    </ReactBootstrap.Button>
                </form>
        );


        ReactDOM.render(formInstance, container);



    });

</script>