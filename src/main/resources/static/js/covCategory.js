var coveragesByCategory = {
    "Personal auto coverages": [
        "Bodily injury liability", 
        "Property damage liability", 
        "Personal injury protection", 
        "Uninsured motorist",
        "Underinsured motorist",
        "Medical payments"
    ],
    "Vehicle coverages": [
        "Collision", 
        "Comprehensive", 
        "Towing and labor coverage", 
        "Rental car expense",
        "Gap coverage"
    ],
}

function changecat(value) {

    if (value.length == 0) document.getElementById("coverageName").innerHTML = "<option></option>";
    else {
        var catOptions = "";
        for (categoryId in coveragesByCategory[value]) {
            catOptions += "<option>" + coveragesByCategory[value][categoryId] + "</option>";
        }
        document.getElementById("coverageName").innerHTML = catOptions;
    }

    if (value == "Personal auto coverages") {
        document.getElementById("code").value = "1000";
    } else if (value == "Vehicle coverages") {
        document.getElementById("code").value = "1100";
    }

}