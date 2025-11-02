import React, { useEffect, useState } from 'react'
import axios from 'axios'


export default function App() {
const [people, setPeople] = useState([])
const [name, setName] = useState('')


useEffect(() => {
axios.get('/api/all').then((r) => setPeople(r.data))
}, [])


const addNew = async () => {
if (!name) return
const r = await axios.post('/api/add', { name })
setPeople((p) => [...p, r.data])
setName('')
}


return (
<div className="p-6 max-w-xl mx-auto">
<h1 className="text-2xl font-bold mb-4">People</h1>
<div className="mb-4">
<input value={name} onChange={(e) => setName(e.target.value)} placeholder="Name" />
<button onClick={addNew}>Add</button>
</div>
<ul>
{people.map((p) => (
<li key={p.id}>{p.name}</li>
))}
</ul>
</div>
)
}