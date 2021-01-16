import React, { useState } from 'react';

const Bottle = () => {

    const [inpValue1, setinpValue1] = useState();
    const [inpValue2, setinpValue2] = useState();
    const [opValue, setopValue] = useState();

    const onClickopValue = () => {
        setopValue(Number(inpValue1)+Number(inpValue2));
    }

    return <div>
        <input value={inpValue1} type="text" onChange={(e)=>{setinpValue1(e.target.value);}} />
        <input value={inpValue2} type="text" onChange={(e)=>{setinpValue2(e.target.value);}} />
        <input value={opValue} type="text" />
            <button onClick={onClickopValue}>Add</button>
            <pre>Output: {opValue}</pre>
        </div>;
}

export default Bottle;